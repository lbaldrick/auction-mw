package com.baldrick.auction.model;

import java.util.List;

public class User {

  private String id;
  private String username;
  private Double rating;
  private List<Feedback> feedback;

  public User(String id, String username, Double rating, List<Feedback> feedback) {
    this.id = id;
    this.username = username;
    this.rating = rating;
    this.feedback = feedback;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public List<Feedback> getFeedback() {
    return feedback;
  }

  public void setFeedback(List<Feedback> feedback) {
    this.feedback = feedback;
  }
}
