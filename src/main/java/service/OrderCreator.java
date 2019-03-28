package service;

import model.Order;

import static utill.PropertyReader.getOrderValue;

public class OrderCreator {

    private final static String VM_CLASS_VALUE = "order.vm.class";
    private final static String INSTANCE_TYPE = "order.instance.type";
    private final static String REGION = "order.region";
    private final static String LOCAL_SSD = "order.ssd";
    private final static String COMMITMENT_TERM = "order.term";
    private final static String NUMBER_OF_INSTANCE = "order.instance.number";
    private final static String ENGINE_TYPE= "order.engine.type";
    private final static String OPERATION_SYSTEM = "order.os";
    private final static String GPU_TYPE = "order.gpy.typy";
    private final static String NUMBER_OF_GPU = "order.gpy.number";

    public static Order getPredefinedOrder(){
        return new Order(getOrderValue(VM_CLASS_VALUE), getOrderValue(INSTANCE_TYPE), getOrderValue(REGION),
                getOrderValue(LOCAL_SSD), getOrderValue(COMMITMENT_TERM),
                Integer.parseInt(getOrderValue(NUMBER_OF_INSTANCE)), getOrderValue(ENGINE_TYPE),
                getOrderValue(OPERATION_SYSTEM), getOrderValue(GPU_TYPE), Integer.parseInt(getOrderValue(NUMBER_OF_GPU)));
    }
}
