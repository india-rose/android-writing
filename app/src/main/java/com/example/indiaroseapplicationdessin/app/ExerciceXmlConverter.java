package com.example.indiaroseapplicationdessin.app;

import storm.xmlbinder.XmlElement;
import storm.xmlbinder.binder.CollectionObjectBinder;
import storm.xmlbinder.binder.ContentBinder;
import storm.xmlbinder.binder.ObjectBinder;
import storm.xmlbinder.transformer.BooleanTransformer;
import storm.xmlbinder.transformer.FloatTransformer;
import storm.xmlbinder.transformer.IntegerTransformer;
import storm.xmlbinder.transformer.StringTransformer;



public final class ExerciceXmlConverter extends AbstractXmlConverter<ExerciceList>
{
	/**
	 * The unique instance of the class.
	 */
	protected static ExerciceXmlConverter s_instance = null;
	
	protected ExerciceXmlConverter()
	{
		String exerciceListClass = "com.example.indiaroseapplicationdessin.app.ExerciceList";
		String exerciceClass = "com.example.indiaroseapplicationdessin.app.Exercice";
	
		String listFieldName = "exercices";
		String imageFieldName = "image";
		String progressFieldName = "progress";
	
	
	
		StringTransformer stringTransformer = new StringTransformer();
		IntegerTransformer intTransformer = new IntegerTransformer();
		BooleanTransformer booleanTransformer = new BooleanTransformer();
		FloatTransformer floatTransformer = new FloatTransformer();
		//ColorTransformer colorTransformer = new ColorTransformer();
		
		
		XmlElement exercices = new XmlElement("exercices", new ObjectBinder("", exerciceListClass));
		XmlElement exercice = new XmlElement("exercice", new CollectionObjectBinder(listFieldName, exerciceClass));
		XmlElement image = new XmlElement("image", new ContentBinder(imageFieldName, stringTransformer));
		XmlElement progress = new XmlElement("progress", new ContentBinder(progressFieldName, intTransformer));
		
		exercice.addChild(image);
		exercice.addChild(progress);
		
		exercices.addChild(exercice);
		
		this.m_rootElement = exercices;
	}
	
	/**
	 * Method to get the instance of the class.
	 * @return the unique instance of the class.
	 */
	public static ExerciceXmlConverter getInstance()
	{
		if(ExerciceXmlConverter.s_instance == null)
		{
			synchronized (ExerciceXmlConverter.class)
			{
				if(ExerciceXmlConverter.s_instance == null)
				{
					ExerciceXmlConverter.s_instance = new ExerciceXmlConverter();
				}
			}
		}
		return ExerciceXmlConverter.s_instance;
	}
}
