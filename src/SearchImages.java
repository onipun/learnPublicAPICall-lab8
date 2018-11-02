import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchImages extends Thread{
	
	private String imageType = "vector";
	private String searchItem;
	private JPanel jPanel;
	private JLabel[] lblNewLabel;
	
	SearchImages(JPanel jPanel, String searchItem){
		this.jPanel = jPanel;
		this.searchItem = searchItem;
		
	}
	
	public void run() {
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("key", "5505372-0973a45a02644f6a43dbedcef"));
		if(searchItem == "" || searchItem == null) {
			params.add(new BasicNameValuePair("q", "car"));
		}else {
			params.add(new BasicNameValuePair("q", searchItem));
		}
		params.add(new BasicNameValuePair("image_type", imageType));
		String strUrl = "https://pixabay.com/api/";
					
		makeHttpRequest(strUrl, "POST", params);
		
	}

	private JSONObject makeHttpRequest(String url, String string, List<NameValuePair> params) {
		// TODO Auto-generated method stub
		
		InputStream is = null;
		String json = "";
		JSONObject jObj = null ;
		JSONObject jObjItem = null;
		JSONArray jArr = null;
		String line = null;
		try {
			//request method is GET
			DefaultHttpClient httpClient = new DefaultHttpClient();
			String paramString = URLEncodedUtils.format(params, "utf-8");
			url += "?" + paramString;
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httpResponse;
			httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : " + httpResponse.getStatusLine().getStatusCode());
			is = httpEntity.getContent();
			
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuffer result = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			is.close();
			json = result.toString();
			jObj = new JSONObject(json);
			lblNewLabel = new JLabel[20];
			
			jPanel.removeAll();
			for(int i = 0; i<20; i++) {
			String previewUrl = jObj.getJSONArray("hits").getJSONObject(i).get("previewURL").toString();
			System.out.println("Total hits : "+jObj.get("total"));
			System.out.println("Preview url : "+previewUrl);
			
			URL url1 = new URL(previewUrl);
			Image image = ImageIO.read(url1);	
			lblNewLabel[i] = new JLabel();
			jPanel.add(lblNewLabel[i]);
			jPanel.revalidate();
			jPanel.repaint();
			JLabel lblimage = new JLabel(new ImageIcon(image));
			System.out.println(lblimage);
			lblNewLabel[i].setIcon(new ImageIcon(image));
			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sdfd");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("JSON array not being handle");
			e.printStackTrace();

		}
		
		return jObj;
		
	}

}
