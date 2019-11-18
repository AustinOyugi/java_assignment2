package assiignment2.quiz12;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author austin-oyugi
 */
public class OrderMessages 
{
    private static final List<String> errMessages = new ArrayList<>();
    
    public OrderMessages()
    {
        init();
    }
    
    public final void init()
    {
       String initialMessages[] = {
       "The Item Number Is Not Numeric",
       "The Quantity is not numeric",
       "The Item number is less than zero(0)",
       "The Item number is greator than 9999",
       "The quantity ordered is less than 1",
       "The quantity ordered is more than 12",
       "The item number is not valid"};
       
       for(String x: initialMessages)
       {
           addMessage(x);
       }
    }
    
    public void addMessage(String message)
    {
        errMessages.add(message);
    }
    
    public String getMessage(int index)
    {
        return errMessages.get(index);
    }
    
    public Object[] getErrorMessages()
    {
        return errMessages.toArray();
    }
}
