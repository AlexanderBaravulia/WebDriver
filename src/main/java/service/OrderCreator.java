package service;

import model.Order;

public class OrderCreator {

    private final static String VM_CLASS_VALUE ="Regular";
    private final static String INSTANCE_TYPE = "n1-standard-8";
    private final static String REGION ="Frankfurt";
    private final static String LOCAL_SSD="2x375 GB";
    private final static String COMMITMENT_TERM="1 Year";
    private final static String NUMBER_OF_INSTANCE="4";
    private final static String INGINE_TYPE= "Compute Engine";
    private final static String OPERATION_SYSTEM = "Free: Debian, CentOS";
    private final static String GPU_TYPE = "NVIDIA Tesla P100";
    private final static String NUMBER_OF_GPU = "4";
    private final static String TOTAL_ESTIMATE = "1,288.75";

    public static Order getPredefinedOrder(){
        return new Order(VM_CLASS_VALUE, INSTANCE_TYPE, REGION, LOCAL_SSD, COMMITMENT_TERM,NUMBER_OF_INSTANCE, INGINE_TYPE,
                OPERATION_SYSTEM, GPU_TYPE, NUMBER_OF_GPU);
    }


}
