package com.ctrip.xpipe.email;

import com.ctrip.xpipe.api.email.Email;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chen.zhu
 * <p>
 * Oct 10, 2017
 */
public class DefaultEmail implements Email {

    private List<String> recipients = new LinkedList<>();
    private List<String> cCers = new LinkedList<>();
    private List<String> bCCers = new LinkedList<>();
    private String sender;
    private String charset;
    private String subject;
    private String bodyContent;

    @Override
    public List<String> getRecipients() {
        return recipients;
    }

    @Override
    public List<String> getCCers() {
        return cCers;
    }

    @Override
    public List<String> getBCCers() {
        return bCCers;
    }

    @Override
    public String getSender() {
        return sender;
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }

    @Override
    public void addRecipient(String emailAddr) {
        recipients.add(emailAddr);
    }

    @Override
    public void addCCer(String emailAddr) {
        cCers.add(emailAddr);
    }

    @Override
    public void addBCCer(String emailAddr) {
        bCCers.add(emailAddr);
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String getCharset() {
        return charset;
    }

    @Override
    public String getBodyContent() {
        return bodyContent;
    }

    @Override
    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }
}
