package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.resource.cci.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import vo.Download;

public class DownloadDao {
	public ArrayList<Download> query(){
		ArrayList<Download> list = new ArrayList<Download>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/excise?useunicode=true&character=utf-8",
					"root","123456");
			String sql = "select * from t_downloadList";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while(rs.next()){
				Download download = new Download();
				download.setId(rs.getInt("id"));
				download.setName(rs.getString("name"));
				download.setPath(rs.getString("path"));
				download.setDescription(rs.getString("description"));
				long size = rs.getLong("size");
				String sizeStr = fileSizeTransfer(size);
				download.setSizeStr(sizeStr);
				download.setStar(rs.getInt("star"));
				download.setImage(rs.getString("image"));
				download.setTime(rs.getString("time"));
				
				list.add(download);
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public Download get(int id){
		Download download=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/excise?useunicode=true&character=utf-8",
					"root","123456");
			String sql = "select * from t_downloadList where id=?";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1,id);
			
			ResultSet rs = (ResultSet) pst.executeQuery();
			if(rs.next()){
				download = new Download();
				download.setId(rs.getInt("id"));
				download.setName(rs.getString("name"));
				download.setPath(rs.getString("path"));
				download.setDescription(rs.getString("description"));
				long size = rs.getLong("size");
				String sizeStr = fileSizeTransfer(size);
				download.setSizeStr(sizeStr);
				download.setStar(rs.getInt("star"));
				download.setImage(rs.getString("image"));
				download.setTime(rs.getString("time"));
				download.setSizeStr(sizeStr);
			}
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return download;
		
	}
	
	public String fileSizeTransfer(long fileSize){
		String mFileSize;
		DecimalFormat df = new DecimalFormat("######0.00");
		double size = (double) fileSize;
		if(size>1024*1024*1024){
			size=size/(1024*1024*1024);
			mFileSize = df.format(size)+"G";
		}else if(size>1024*1024){
			size=size/(1024*1024);
			mFileSize = df.format(size)+"MB";
		}else if(size>1024){
			size=size/1024;
			mFileSize = df.format(size)+"KB";
		}else{
			mFileSize = df.format(size)+"B";
		}
		return mFileSize;
	}
}
