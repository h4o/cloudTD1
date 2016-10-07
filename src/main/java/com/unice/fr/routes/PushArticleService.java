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
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by user on 07/10/16.
 */
public class PushArticleService extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Article a = gson.fromJson(req.getReader(), Article.class);
        ///AJOUTE QUEUE
        Queue queue = QueueFactory.getQueue("queue-base");
        String art = gson.toJson(a,Article.class);
        queue.add(TaskOptions.Builder.withUrl("/push/handler/").method(TaskOptions.Method.POST).payload(art));
        response.setContentType("application/json");
        response.getWriter().println(art);
    }
}
