package com.cleverplumber.app.decorator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class DateDecorator implements DisplaytagColumnDecorator
{
   public Object decorate(Object object, PageContext pageContext, MediaTypeEnum mediaTypeEnum) throws DecoratorException
   {
      if (object != null)
      {
         DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         return format.format(object);
      }
      else
      {
         return object;
      }
   }
}