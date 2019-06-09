package com.example.demo.sentimiento;

import opennlp.tools.doccat.*;
import opennlp.tools.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class Clasificar {

    private DoccatModel modelo;
    private DocumentCategorizerME categ;

    @Value("classpath:tweets.txt")
    private Resource resourceFile;

    public DoccatModel getModelo(){
        return modelo;
    }

    public void setModelo(DoccatModel modelo){
        this.modelo = modelo;
    }

    @PostConstruct
    public void train(){
        InputStreamFactory dataIn = null;
        try {
            FeatureGenerator[] def = { new BagOfWordsFeatureGenerator() };
            DoccatFactory factory=new DoccatFactory(def);
            File tweets = resourceFile.getFile();
            dataIn=new MarkableFileInputStreamFactory(tweets);
            ObjectStream<String> lineStream=new PlainTextByLineStream(dataIn, StandardCharsets.UTF_8);
            ObjectStream<DocumentSample> sampleStream=new DocumentSampleStream(lineStream);

            TrainingParameters params = TrainingParameters.defaultParams();
            params.put(TrainingParameters.CUTOFF_PARAM, Integer.toString(0));
            params.put(TrainingParameters.ITERATIONS_PARAM, Integer.toString(100));

            this.modelo=DocumentCategorizerME.train("es",sampleStream,params,factory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.categ=new DocumentCategorizerME(this.modelo);
    }

    public Boolean classify(String tweet){

        String[] words=tweet.replaceAll("[^A-Za-z]"," ").split(" ");
        double[] prob=categ.categorize(words);
        //Double positive = prob[0];
        //Como son 2 categorias= positivo = 100% - negativo%
        Double negative = prob[1];
        if(0.2 < negative) { return false; }
        else { return true; }
    }
}
