package com.sode.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sode.dto.AuthorDTO;


@Document(collection = "post")
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	
	private AuthorDTO author;
	private Instant date;
	private String title;
	private String body;
	
	public Post() {}
	
	public Post(String id, AuthorDTO author, Instant date, String title, String body) {
		this.id = id;
		this.author = author;
		this.date = date;
		this.title = title;
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", date=" + date + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
	

}
