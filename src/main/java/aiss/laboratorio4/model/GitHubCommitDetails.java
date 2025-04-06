package aiss.laboratorio4.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubCommitDetails {

    @JsonProperty("url")
    private String url;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("commit")
    private Commit commit;
    @JsonProperty("author")
    private Author author;  // Cambiado de Author__1 a Author
    @JsonProperty("committer")
    private Committer committer;  // Cambiado de Committer__1 a Committer
    @JsonProperty("parents")
    private List<Parent> parents;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    @JsonProperty("commit")
    public Commit getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(Commit commit) {
        this.commit = commit;
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

    @JsonProperty("parents")
    public List<Parent> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "GitHubCommitDetails {\n" +
                "  sha='" + (sha != null ? sha : "N/A") + "',\n" +
                "  url='" + (url != null ? url : "N/A") + "',\n" +
                "  nodeId='" + (nodeId != null ? nodeId : "N/A") + "',\n" +
                "  htmlUrl='" + (htmlUrl != null ? htmlUrl : "N/A") + "',\n" +
                "  commentsUrl='" + (commentsUrl != null ? commentsUrl : "N/A") + "',\n" +
                "  commit=" + (commit != null ? commit.toString().indent(4).trim() : "N/A") + ",\n" +
                "  author=" + (author != null ? author.getName() + " <" + author.getEmail() + ">" : "N/A") + ",\n" +
                "  committer=" + (committer != null ? committer.getName() + " <" + committer.getEmail() + ">" : "N/A") + ",\n" +
                "  parents=" + (parents != null ? parents.size() + " parent(s)" : "N/A") + "\n" +
                '}';
    }

}
