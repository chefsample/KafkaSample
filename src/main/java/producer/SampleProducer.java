package producer;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class SampleProducer {
    public static void main(String args[]){

        Properties props = new Properties();

        props.put("bootstrap.servers","localhost:9093, localhost:9094");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer <String,String> myProducer = new KafkaProducer<String,String>(props);

        //ProducerRecord myRecord = new ProducerRecord("topic_2","course1","Message 1");

        try{
            for(int i = 0; i < 150; i++)
            {
                myProducer.send(new ProducerRecord<String, String>("topic_2",Integer.toString(i),"My Message:"+Integer.toString(i)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myProducer.close();
        }


    }
}
