package com.baldrick.auction.model;


public class Feedback {
    private double deliverTimeRating;
    private double accuracyRating;
    private double communicationRating;
    private double packagingRating;
    private String comment;

    public Feedback(double deliverTimeRating, double accuracyRating, double communicationRating, double packagingRating, String comment) {
        this.deliverTimeRating = deliverTimeRating;
        this.accuracyRating = accuracyRating;
        this.communicationRating = communicationRating;
        this.packagingRating = packagingRating;
        this.comment = comment;
    }

    public double getDeliverTimeRating() {
        return deliverTimeRating;
    }

    public void setDeliverTimeRating(double deliverTimeRating) {
        this.deliverTimeRating = deliverTimeRating;
    }

    public double getAccuracyRating() {
        return accuracyRating;
    }

    public void setAccuracyRating(double accuracyRating) {
        this.accuracyRating = accuracyRating;
    }

    public double getCommunicationRating() {
        return communicationRating;
    }

    public void setCommunicationRating(double communicationRating) {
        this.communicationRating = communicationRating;
    }

    public double getPackagingRating() {
        return packagingRating;
    }

    public void setPackagingRating(double packagingRating) {
        this.packagingRating = packagingRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }   
}
