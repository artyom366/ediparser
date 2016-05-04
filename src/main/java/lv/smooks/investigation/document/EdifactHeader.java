package lv.smooks.investigation.document;


public class EdiFactHeader {

    private String messageReferenceNumber;
    private String messageType;
    private String messageTypeVersionNumber;
    private String messageTypeReleaseNumber;
    private String controllingAgency;
    private String assignedCode;

    public String getMessageReferenceNumber() {
        return messageReferenceNumber;
    }

    public void setMessageReferenceNumber(String messageReferenceNumber) {
        this.messageReferenceNumber = messageReferenceNumber;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageTypeVersionNumber() {
        return messageTypeVersionNumber;
    }

    public void setMessageTypeVersionNumber(String messageTypeVersionNumber) {
        this.messageTypeVersionNumber = messageTypeVersionNumber;
    }

    public String getMessageTypeReleaseNumber() {
        return messageTypeReleaseNumber;
    }

    public void setMessageTypeReleaseNumber(String messageTypeReleaseNumber) {
        this.messageTypeReleaseNumber = messageTypeReleaseNumber;
    }

    public String getControllingAgency() {
        return controllingAgency;
    }

    public void setControllingAgency(String controllingAgency) {
        this.controllingAgency = controllingAgency;
    }

    public String getAssignedCode() {
        return assignedCode;
    }

    public void setAssignedCode(String assignedCode) {
        this.assignedCode = assignedCode;
    }
}
