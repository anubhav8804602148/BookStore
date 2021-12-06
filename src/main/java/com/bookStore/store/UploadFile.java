package com.bookStore.store;

import java.io.File; 
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class UploadFile {
	File file;
	BookRepository bookRepo;
	JFrame frame;
	JFileChooser jfc;
	UploadFile(){
		frame = new JFrame("Upload Multiple Books");
		jfc = new JFileChooser();
		frame.add(jfc);
		jfc.showOpenDialog(frame);
		file = jfc.getSelectedFile();
		uploadDataToDatabaseJDBC();
	}
	public static void main(String[] ra){
		new UploadFile();
	}
	
	public void uploadDataToDatabaseJDBC() {
		try {
			Scanner in = new Scanner(file);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myBookStore","anubhav","anubhav");
			PreparedStatement statement = con.prepareStatement("insert into mybookstore.books values(?,?,?,?)");
			statement.setString(0, null);
			ResultSet rs = statement.executeQuery("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uploadDataToDatabase() {
		if(file==null) {
			System.out.println("No data found!");
			return;
		}
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		while(in.hasNext()) {
			String[] bookRow = in.nextLine().split("\\|");
			System.out.println(Arrays.toString(bookRow));
			Book book = new Book();
			book.setTitle(bookRow[0]);
			book.setAuthor(bookRow[1]);
			book.setDownloadLink(bookRow[3]);
			try {
				Date date = new Date(Long.parseLong(bookRow[2].replace("-", "")));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			bookRepo.save(book);
		}
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
}
