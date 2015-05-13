package servlets;

import objects.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by Nikolay on 13.05.2015.
 */
@WebServlet(urlPatterns="/ShowImageServlet", name = "ShowImageServlet")
public class ShowImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response, request);
}

    public void processRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("Image/jpg");
        OutputStream out = response.getOutputStream();
        System.out.println("SEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEERRRRRRVVVVVVVVVVVVVVVVVVVVVLLLLLET ");
        try {
            int index = Integer.valueOf(request.getParameter("index"));
            System.out.println("SEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEERRRRRRVVVVVVVVVVVVVVVVVVVVVLLLLLET "+index);
            ArrayList<Book> bookList = (ArrayList<Book>) request.getSession().getAttribute("currentBookList");
            for(Book book : bookList){
                if (book.getId()==index){
                    response.setContentLength(book.getImage().length);
                    out.write(book.getImage());
                }
            }

        }finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response,request);
    }
}
