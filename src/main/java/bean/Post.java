package bean;

public class Post {
	private int post_id;
    private String user_id;
    private String content;
    private java.sql.Timestamp post_time;

    // getter and setter for id
    public int getPost_id() {
        return post_id;
    }

    // getter and setter for name
    public String getUser_id() {
        return user_id;
    }

    // getter and setter for content
    public String getContent() {
        return content;
    }


    // getter and setter for postDate
    public java.sql.Timestamp getPost_time() {
        return post_time;
    }
    
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public void setPost_time(java.sql.Timestamp post_time) {
        this.post_time = post_time;
    }
}
