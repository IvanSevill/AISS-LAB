
package aiss.laboratorio4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    @JsonProperty("url")
    private String url;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("committer")
    private Committer committer;
    @JsonProperty("message")
    private String message;
    @JsonProperty("tree")
    private Tree tree;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("verification")
    private Verification verification;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("committer")
    public Committer getCommitter() {
        return committer;
    }

    @JsonProperty("committer")
    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("tree")
    public Tree getTree() {
        return tree;
    }

    @JsonProperty("tree")
    public void setTree(Tree tree) {
        this.tree = tree;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("verification")
    public Verification getVerification() {
        return verification;
    }

    @JsonProperty("verification")
    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    @Override
    public String toString() {
        return "Commit {\n" +
                "  message='" + (message != null ? message : "N/A") + "',\n" +
                "  url='" + (url != null ? url : "N/A") + "',\n" +
                "  author=" + (author != null ? author.getName() + " <" + author.getEmail() + ">" : "N/A") + ",\n" +
                "  committer=" + (committer != null ? committer.getName() + " <" + committer.getEmail() + ">" : "N/A") + ",\n" +
                "  tree=" + (tree != null ? tree.getSha() : "N/A") + ",\n" +
                "  commentCount=" + (commentCount != null ? commentCount : "N/A") + ",\n" +
                "  verification=" + (verification != null ? verification.getVerified() : "N/A") + "\n" +
                '}';
    }


}
