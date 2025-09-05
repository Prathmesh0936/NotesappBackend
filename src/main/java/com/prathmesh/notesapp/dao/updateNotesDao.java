package com.prathmesh.notesapp.dao;

public class updateNotesDao {
	
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "updateNotesDao [title=" + title + ", content=" + content + "]";
	}
	
}
