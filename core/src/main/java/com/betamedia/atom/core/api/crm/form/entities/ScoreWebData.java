package com.betamedia.atom.core.api.crm.form.entities;

import com.opencsv.bean.CsvBindByName;

public class ScoreWebData {
	@CsvBindByName
    private String questionFNS;
    @CsvBindByName
    private String answerFNS;
    @CsvBindByName
    private int score;
    
    public String getQuestionFNS() {
        return questionFNS;
    }
    
    public String getAnswerFNS() {
        return answerFNS;
    }
    
    public int getScore() {
        return score;
    }

}
