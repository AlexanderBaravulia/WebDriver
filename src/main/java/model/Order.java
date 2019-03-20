package model;

import java.util.Objects;

public class Order {
    private  String vmClass;
    private  String instanceType;
    private  String region;
    private  String localSsd;
    private  String commitmentTerm;

    public Order(String vmClass, String instanceType, String region, String localSsd, String commitmentTerm) {
        this.vmClass = vmClass;
        this.instanceType = instanceType;
        this.region = region;
        this.localSsd = localSsd;
        this.commitmentTerm = commitmentTerm;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(vmClass, order.vmClass) &&
                Objects.equals(instanceType, order.instanceType) &&
                Objects.equals(region, order.region) &&
                Objects.equals(localSsd, order.localSsd) &&
                Objects.equals(commitmentTerm, order.commitmentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vmClass, instanceType, region, localSsd, commitmentTerm);
    }

    @Override
    public String toString() {
        return "Order{" +
                "vmClass='" + vmClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", region='" + region + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                '}';
    }
}
