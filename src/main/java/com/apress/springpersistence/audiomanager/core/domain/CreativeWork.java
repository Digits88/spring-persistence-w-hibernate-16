package com.apress.springpersistence.audiomanager.core.domain;


import org.springframework.cache.annotation.Caching;

import javax.persistence.*;
import java.net.URL;
import java.util.*;

/**
 * Created by pfisher on 9/29/14.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "creativeWorkWithComments",
                attributeNodes = {
                        @NamedAttributeNode("comments")
                }
        )
})
public class CreativeWork extends Thing {

    private String headline;
    private String alternativeHeadline;

    @ManyToOne
    private Person author;
    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL})
    private Set<Comment> comments = new HashSet<Comment>();

    public boolean addComment(Comment comment) {
        comment.setCreativeWork(this);
        return this.getComments().add(comment);
    }

    @ManyToMany(mappedBy = "creativeWorks")
    private Set<Category> categories = new HashSet<Category>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private MediaData mediaData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private MediaDataLow mediaDataLow;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private MediaDataHigh mediaDataHigh;

    @Temporal(TemporalType.DATE)
    private Date datePublished;

    private URL discussionUrl;

    private String genre;


    private Boolean isFamilyFriendly;

    private String keywords;
    private URL license;

    @ManyToOne
    private Organization publisher; //Organization
    @OneToMany
    private Set<Review> reviews = new HashSet<Review>();

    @Column(length = 4000, nullable = true)
    @Basic(fetch = FetchType.LAZY)
    @Lob()
    private String text;

    private URL thumbnail;
    @ManyToOne
    private Duration timeRequired;

    public Boolean getFamilyFriendly() {
        return isFamilyFriendly;
    }

    public void setFamilyFriendly(Boolean familyFriendly) {
        isFamilyFriendly = familyFriendly;
    }

    public Organization getPublisher() {
        return publisher;
    }

    public void setPublisher(Organization publisher) {
        this.publisher = publisher;
    }

    public String getAlternativeHeadline() {
        return alternativeHeadline;
    }

    public void setAlternativeHeadline(String alternativeHeadline) {
        this.alternativeHeadline = alternativeHeadline;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(SortedSet<Comment> comments) {
        this.comments = comments;
    }

    public Integer getCommentCount() {
        return this.comments.size();
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public URL getDiscussionUrl() {
        return discussionUrl;
    }

    public void setDiscussionUrl(URL discussionUrl) {
        this.discussionUrl = discussionUrl;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }


    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public URL getLicense() {
        return license;
    }

    public void setLicense(URL license) {
        this.license = license;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public boolean addReview(Review review) {
        return this.getReviews().add(review);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public URL getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(URL thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Duration getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(Duration timeRequired) {
        this.timeRequired = timeRequired;
    }


    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public MediaData getMediaData() {
        return mediaData;
    }

    public void setMediaData(MediaData mediaData) {
        this.mediaData = mediaData;
    }

    public MediaDataLow getMediaDataLow() {
        return mediaDataLow;
    }

    public void setMediaDataLow(MediaDataLow mediaDataLow) {
        this.mediaDataLow = mediaDataLow;
    }

    public MediaDataHigh getMediaDataHigh() {
        return mediaDataHigh;
    }

    public void setMediaDataHigh(MediaDataHigh mediaDataHigh) {
        this.mediaDataHigh = mediaDataHigh;
    }
}
