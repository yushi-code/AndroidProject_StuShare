package com.example.stu_share;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageCordinator {
    public final static List<Message> MESSAGE_LIST=new ArrayList<Message>();

    public static class Message implements Serializable {
        public String id, title, detail, receiver_email, sender_email, type, status;

        public Message(String id, String title, String detail, String receiver_email, String sender_email, String type,  String status){
            this.id = id;
            this.title = title;
            this.detail = detail;
            this.receiver_email = receiver_email;
            this.sender_email = sender_email;
            this.type = type;
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getReceiver_email() {
            return receiver_email;
        }

        public void setReceiver_email(String receiver_email) {
            this.receiver_email = receiver_email;
        }

        public String getSender_email() {
            return sender_email;
        }

        public void setSender_email(String sender_email) {
            this.sender_email = sender_email;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        @Override
        public String toString() {
            return title  ;
        }
    }
}
