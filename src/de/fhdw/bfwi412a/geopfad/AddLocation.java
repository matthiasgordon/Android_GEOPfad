package de.fhdw.bfwi412a.geopfad;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddLocation extends Activity {


		static final int IMAGE_URL = 100;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.add_location);
			
			
			
			final String xmlFile = "neueOrte";
			Button btnAnlegen = (Button)findViewById(R.id.btnAnlegen);
			Button btnbildurl = (Button)findViewById(R.id.btnbildurl);
			final EditText etOrtName = (EditText) findViewById(R.id.etxtName);
			final EditText etAbout = (EditText) findViewById(R.id.etxtAbout);
			
			
			
			btnbildurl.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					/*FileChooser filec = new FileChooser();
					File sdcard = new File("/sdcard/");
					filec.setCurrentDir(sdcard);
					filec.fill(filec.getCurrentDir());
					filec.getUrl();*/
					   
					Intent intent = new Intent(AddLocation.this, FileChooser.class);
					startActivity(intent);
					startActivityForResult(intent, IMAGE_URL);
					
					
					
				}
			});
			
			
			
			btnAnlegen.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						String ortName = etOrtName.getText().toString();
						String about = etAbout.getText().toString();
					    //FileOutputStream fos = new  FileOutputStream("neueOrte.xml");
						
						File ortxml = new File(Environment.getExternalStorageDirectory().getPath() + "/orte.xml");
						
						if(ortxml.exists()){
			
							DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
					        //Create the documentBuilder
					        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
					        //Create the Document  by parsing the file
					        Document document = documentBuilder.parse(ortxml);
					         //Get the root element of the xml Document;
					        
					        System.out.println(document);
					    	
					    	Node node =  document.getElementsByTagName("orte").item(0);
					    	
					    	org.w3c.dom.Element newOrt = document.createElement("ort");
					    	
					    	org.w3c.dom.Element newOrtName = document.createElement("ortname");
					    	newOrtName.appendChild(document.createTextNode(ortName));
					    	newOrt.appendChild(newOrtName);
					    	
					    	org.w3c.dom.Element newAbout = document.createElement("about");
					    	newAbout.appendChild(document.createTextNode(about));
					    	newOrt.appendChild(newAbout);
					    	
					    	node.appendChild(newOrt);
					    	
					    	TransformerFactory factory = TransformerFactory.newInstance();
					    	Transformer transformer = factory.newTransformer();

					    	DOMSource source = new DOMSource(document);
					    	StreamResult result = new StreamResult(ortxml);
					    	transformer.transform(source, result);
				
						}
						
					    else {
					    	 FileOutputStream fileos= new FileOutputStream(ortxml);//getApplicationContext().openFileOutput(xmlFile, Context.MODE_PRIVATE);
							    XmlSerializer xmlSerializer = Xml.newSerializer();              
							    StringWriter writer = new StringWriter();
							    xmlSerializer.setOutput(writer);
							    xmlSerializer.startDocument("UTF-8", true);
							    xmlSerializer.startTag(null, "orte");
							    xmlSerializer.startTag(null, "ort");
							    xmlSerializer.startTag(null, "ortname");
							    xmlSerializer.text(ortName);
							    xmlSerializer.endTag(null, "ortname");
							    xmlSerializer.startTag(null,"about");
							    xmlSerializer.text(about);
							    xmlSerializer.endTag(null, "about");             
							    xmlSerializer.endTag(null, "ort");
							    xmlSerializer.endTag(null, "orte");
							    xmlSerializer.endDocument();
							    xmlSerializer.flush();
							    String dataWrite = writer.toString();
							    fileos.write(dataWrite.getBytes());
							    fileos.close();
					    }
					    
					    
					}
					catch (FileNotFoundException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					catch (IllegalArgumentException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					catch (IllegalStateException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					catch (IOException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					ArrayList<String> userData = new ArrayList<String>();
					String data = null;
					
					try {
					  FileInputStream  fis = new FileInputStream(Environment.getExternalStorageDirectory().getPath() + "/orte.xml");
					   InputStreamReader isr = new InputStreamReader(fis);
					   char[] inputBuffer = new char[fis.available()]; 
					    isr.read(inputBuffer);
					    data = new String(inputBuffer);
					    isr.close();
					    fis.close();
					}
					catch (FileNotFoundException e3) {
					    // TODO Auto-generated catch block
					    e3.printStackTrace();
					}
					catch (IOException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					
					XmlPullParserFactory factory = null;
					XmlPullParser xpp = null;
					int eventType = 0;
					
					try {
						factory = XmlPullParserFactory.newInstance();
						factory.setNamespaceAware(true);
					    xpp = factory.newPullParser();
					    xpp.setInput(new StringReader(data));
					    eventType = xpp.getEventType();
					}
					catch (XmlPullParserException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					
					
					while (eventType != XmlPullParser.END_DOCUMENT){
						
					    if (eventType == XmlPullParser.START_DOCUMENT) {
					        System.out.println("Start document");
					    }
					    else if (eventType == XmlPullParser.START_TAG) {
					        System.out.println("Start tag "+xpp.getName());
					    }
					    else if (eventType == XmlPullParser.END_TAG) {
					        System.out.println("End tag "+xpp.getName());
					    }
					    else if(eventType == XmlPullParser.TEXT) {
					        userData.add(xpp.getText());
					    }
					    
					    try {
					        eventType = xpp.next();
					    }
					    catch (XmlPullParserException e) {
					        // TODO Auto-generated catch block
					        e.printStackTrace();
					    }
					    catch (IOException e) {
					        // TODO Auto-generated catch block
					        e.printStackTrace();
					    }
					}
					
					TextView ortName = (TextView) findViewById(R.id.txtName);
							ortName.setText(userData.get(0));
							
					TextView about = (TextView) findViewById(R.id.txtAbout);
							about.setText(userData.get(1));
				}
			});	
		}	
		
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if (resultCode == RESULT_OK && requestCode == IMAGE_URL) {
		    if (data.hasExtra("bildurl")) {
		    	TextView url = (TextView) findViewById(R.id.bildurl);
		    	url.setText(data.getExtras().getString("bildurl"));
		      /*Toast.makeText(this, data.getExtras().getString("bildurl"),
		        Toast.LENGTH_SHORT).show();*/
		      
		    }
		  }
		} 
}
