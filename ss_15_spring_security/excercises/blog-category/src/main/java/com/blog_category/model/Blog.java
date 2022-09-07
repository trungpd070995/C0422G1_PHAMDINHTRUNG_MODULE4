package com.blog_category.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "blog_name")
    private String blogName;
    @Column(name = "author")
    private String authorName;
    @Column(name = "blog_content", columnDefinition = "text")
    private String blogContent;
    @ManyToOne
    @JoinColumn(name = "categoty_id", referencedColumnName = "categoryId", nullable = false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public Blog() {
    }

    public Blog(Long id, String blogName, String authorName, String blogContent, Category category) {
        this.id = id;
        this.blogName = blogName;
        this.authorName = authorName;
        this.blogContent = blogContent;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
