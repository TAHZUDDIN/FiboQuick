package example.com.fibonacciquicksort.util;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class StudentRecord implements Serializable
{
    Integer rank;
    String name ;
    List<String> subjects;
    List<Integer> scores;
    Map<String,Integer> mapSubMark;
    Integer total;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public Map<String, Integer> getMapSubMark() {
        return mapSubMark;
    }

    public void setMapSubMark(Map<String, Integer> mapSubMark) {
        this.mapSubMark = mapSubMark;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
