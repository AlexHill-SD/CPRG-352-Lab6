/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BritishWaldo
 */
public class ShoppingListServlet extends HttpServlet
{
    private ArrayList<String> itemList = new ArrayList<String>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String actionValue = "";
        
        if(request.getParameterMap().containsKey("action"))
        {
            actionValue =  request.getParameter("action");
        }
        
        if(actionValue.equals("logout"))
        {
            session.invalidate();
            
            session = request.getSession();
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        else if (session.getAttribute("username") != null)
        {
            request.setAttribute("username", session.getAttribute("username"));
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        String actionValue = request.getParameter("action");
        
        switch (actionValue)
        {
            case "register":
                String inputUsername = request.getParameter("username");
                
                if (inputUsername == null || inputUsername.equals(""))
                {
                    request.setAttribute("error_message", "Please don't leave the username blank!");
                    
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;
                }
                else
                {
                    this.itemList = new ArrayList<String>();
                    
                    System.out.println(this.itemList.size());
                    
                    session.setAttribute("username", request.getParameter("username"));
                    
                    request.setAttribute("username", session.getAttribute("username"));
                    
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    return;
                }
            case "addItem":
                String newItem = (String) request.getParameter("newItem");
                
                this.itemList.add(newItem);
                
                session.setAttribute("itemList", this.itemList);
                request.setAttribute("itemList", this.itemList);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            case "deleteItem":
                String itemToDelete = (String) request.getParameter("itemToDelete");
                
                this.itemList.remove(itemToDelete);
                
                session.setAttribute("itemList", this.itemList);
                
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            default:
                break;
        }
    }
}
