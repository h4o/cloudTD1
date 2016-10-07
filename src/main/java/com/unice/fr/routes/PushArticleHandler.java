package com.unice.fr.routes;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
import com.unice.fr.entities.Article;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 07/10/16.
 */
public class PushArticleHandler extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WE WAIT NAH");


        response.setContentType("application/json");
        response.getWriter().println("{}");
    }
}
