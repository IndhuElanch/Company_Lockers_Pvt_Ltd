package com.lockedme;

/*Developed by Indumathi submitted on 29 Jan,2022
*Focused on file handling methods like creation,search,
*deletion,display of file information.
**/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {
	
	static final String projectLocation="D:\\LockedMe";
	
	public static void main(String[] args) {
		File path = new File(projectLocation);
		Scanner obj = new Scanner(System.in);
		int val=0;
		try {
			do {
				displayOptions();
				System.out.println("Enter your choice:\n");
				val = Integer.parseInt(obj.nextLine());
				switch(val) {
				case 1:
					displayFiles(path);
					break;
				case 2:
					createFile(obj);
					break;
				case 3:
					searchFile(obj);
					break;
				case 4:
					deleteFile(obj);
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option\n");
					
				}			
			}while(val>0&&val<=6);
		}
		
		catch(Exception e) {
			System.out.println("Make sure to give interger values.\nContact Administrator\n ");
		}
		
		finally{
			obj.close();
		}
	}
	
	/**
	 * Funtion Name - displayOptions
	 * Responsible for listing the options for file operation
	 */
	public static void displayOptions() {
		System.out.println("************************************************************\n");
		System.out.println("\t\t\tLockedMe.com\n");
		System.out.println("************************************************************\n");
		System.out.println("\t1)Display Contents of the Main Directory\n");
		System.out.println("\t2)Add file to Main Directory\n");
		System.out.println("\t3)Search Main Directory for file\n");
		System.out.println("\t4)Delete file from Main Directory\n");
		System.out.println("\t5)Exit\n");
		System.out.println("************************************************************\n");
	}
	
	
	/**
	 * Funtion Name - displayFiles
	 * @param - LockedMe Root Directory
	 * Responsible for listing the files present in LockedMe Directory
	 */
	public static void displayFiles(File folder) {
		try {
			if(folder.listFiles().length==0) {
				System.out.println("\tNo files present in Root directory\n");
			}
			if(folder.getAbsolutePath().equals(projectLocation)) {
				System.out.println(folder.getName()+":\n");
			}
			for(File file:folder.listFiles()) {
				if(file.isDirectory())
				{
					if(file.listFiles().length==0) {
						System.out.println("\tNo files present in directory "+file.getName());
					}
					else {
						displayFiles(file);
					}
				}
				else {
					System.out.println("\t"+file);
				}
			}
		}
		catch(Exception e) {
			System.out.println("LockedMe Root Directory Not Found/Error Occured. Contact Administrator\n");
		}
	}
	
	
	/**
	 * Funtion Name - createFile
	 * @param - Scanner Object
	 * Responsible for listing the files present in LockedMe Directory
	 */
	public static void createFile(Scanner obj) {
		try {
			String fileName;
			int lines=0;
			
			System.out.println("Enter New File to be created:\n");
			fileName = obj.nextLine();
			System.out.println("Enter Number of lines to be written:\n");
			lines = Integer.parseInt(obj.nextLine());
			FileWriter writer = new FileWriter(projectLocation+"\\"+fileName);
			
			for(int i=0; i<lines; i++) {
				System.out.println("Enter text to be written:");
				writer.write(obj.nextLine()+System.lineSeparator());
			}
			writer.close();
			System.out.println("File "+fileName+" created");
		}
		catch(Exception e) {
			System.out.println("Some Error Occured Contact Administrator\n");
		}
		
	}
	
	
	
	/**
	 * Funtion Name - deleteFile
	 * @param - Scanner Object
	 * Responsible for deleting the files present in LockedMe Directory
	 */
	public static void deleteFile(Scanner obj) {
		try 
		{
			String fileName;
			System.out.println("Enter File to delete:\n");
			fileName = obj.nextLine();
			File handler = new File(projectLocation+"\\"+fileName);
			if(handler.exists())
			{
				if(handler.delete())
				{
					System.out.println("Deleted "+fileName+" Successfully\n");
				}
				else
				{
					System.out.println("Not able to delete file\n");
				}
			}
			else {
				System.out.println("File doesn't exist\n");
			}
		}
		catch(Exception e) {
			System.out.println("Some Error Occured Contact Administrator\n");
		}
	}
	
	/**
	 * Funtion Name - searchFile
	 * @param - Scanner Object
	 * Responsible for Searching if file is present in LockedMe Directory
	 */
	public static void searchFile(Scanner obj) {
		try 
		{
			String fileName;
			System.out.println("Enter File to be searched:\n");
			fileName = obj.nextLine();
			File handler = new File(projectLocation+"\\"+fileName);
			if(handler.exists())
			{
				System.out.println("File "+fileName+" is available\n");
			}
			else
			{
				System.out.println("File doesn't exist\n");
			}

		}
		catch(Exception e) {
			System.out.println("Some Error Occured Contact Administrator\n");
		}
	}
}
