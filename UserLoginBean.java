

package com.uttara.dyn.eval.beans;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class UserLoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long slno;	
	private String firstName;
	private String lastName;
	private String name;	
	private String emailId;
	private String loginName;
	private String password;
	private String role;
	private String batchNo;
	private String vidApplVersion;
	private String semAppVersion;
	private String courseName;
	
	
	private String uttaraId;
	private String passedOutYear, college;
	private Date dob;	
	private Date ipDate;
	private String address;	
	private String mobile;
	private String batchId, batchName;
	private String education, selectedEducation, otherEducation;	
	private String specialization, selectedSpecialization, otherSpecialization;
	private String aboutUttara;
	private boolean uploadResume;
	private boolean uploadPhoto;
	private String ofileFileName,imgFileFileName;	
	private String imgFileContentType;
	private byte[] blobObj;
	private byte[] blobImage;
	private File ofile;
	private File imgFile;
	private double noOfYears,aggregate ;
	private double tenThAgg, twelthAgg, diplomaAggr;
	private String imgFilePath;
	private int imgSlno ;
	private String cookieId; 
	private String specialStudent;
	private String searchName;
	private String ipAddr;
	private String status;
	
	
	public String getUttaraId() {
		return uttaraId;
	}
	public void setUttaraId(String uttaraId) {
		this.uttaraId = uttaraId;
	}
	public String getPassedOutYear() {
		return passedOutYear;
	}
	public void setPassedOutYear(String passedOutYear) {
		this.passedOutYear = passedOutYear;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSelectedEducation() {
		return selectedEducation;
	}
	public void setSelectedEducation(String selectedEducation) {
		this.selectedEducation = selectedEducation;
	}
	public String getOtherEducation() {
		return otherEducation;
	}
	public void setOtherEducation(String otherEducation) {
		this.otherEducation = otherEducation;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getSelectedSpecialization() {
		return selectedSpecialization;
	}
	public void setSelectedSpecialization(String selectedSpecialization) {
		this.selectedSpecialization = selectedSpecialization;
	}
	public String getOtherSpecialization() {
		return otherSpecialization;
	}
	public void setOtherSpecialization(String otherSpecialization) {
		this.otherSpecialization = otherSpecialization;
	}
	public String getAboutUttara() {
		return aboutUttara;
	}
	public void setAboutUttara(String aboutUttara) {
		this.aboutUttara = aboutUttara;
	}
	public boolean isUploadResume() {
		return uploadResume;
	}
	public void setUploadResume(boolean uploadResume) {
		this.uploadResume = uploadResume;
	}
	public boolean isUploadPhoto() {
		return uploadPhoto;
	}
	public void setUploadPhoto(boolean uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}
	public String getOfileFileName() {
		return ofileFileName;
	}
	public void setOfileFileName(String ofileFileName) {
		this.ofileFileName = ofileFileName;
	}
	public String getImgFileFileName() {
		return imgFileFileName;
	}
	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}
	public String getImgFileContentType() {
		return imgFileContentType;
	}
	public void setImgFileContentType(String imgFileContentType) {
		this.imgFileContentType = imgFileContentType;
	}
	public byte[] getBlobObj() {
		return blobObj;
	}
	public void setBlobObj(byte[] blobObj) {
		this.blobObj = blobObj;
	}
	public byte[] getBlobImage() {
		return blobImage;
	}
	public void setBlobImage(byte[] blobImage) {
		this.blobImage = blobImage;
	}
	public File getOfile() {
		return ofile;
	}
	public void setOfile(File ofile) {
		this.ofile = ofile;
	}
	public File getImgFile() {
		return imgFile;
	}
	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}
	public double getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(double noOfYears) {
		this.noOfYears = noOfYears;
	}
	public double getAggregate() {
		return aggregate;
	}
	public void setAggregate(double aggregate) {
		this.aggregate = aggregate;
	}
	public double getTenThAgg() {
		return tenThAgg;
	}
	public void setTenThAgg(double tenThAgg) {
		this.tenThAgg = tenThAgg;
	}
	public double getTwelthAgg() {
		return twelthAgg;
	}
	public void setTwelthAgg(double twelthAgg) {
		this.twelthAgg = twelthAgg;
	}
	public double getDiplomaAggr() {
		return diplomaAggr;
	}
	public void setDiplomaAggr(double diplomaAggr) {
		this.diplomaAggr = diplomaAggr;
	}
	public String getImgFilePath() {
		return imgFilePath;
	}
	public void setImgFilePath(String imgFilePath) {
		this.imgFilePath = imgFilePath;
	}
	public int getImgSlno() {
		return imgSlno;
	}
	public void setImgSlno(int imgSlno) {
		this.imgSlno = imgSlno;
	}
	public long getSlno() {
		return slno;
	}
	public void setSlno(long slno) {
		this.slno = slno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	public String getName() {
		String name =  getFirstName() + " " + getLastName();			
		return name;
	}
	public void setName(String name) {		
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return loginName+"";
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setVidApplVersion(String vidApplVersion) {
		this.vidApplVersion = vidApplVersion;
	}
	public String getVidApplVersion() {
		return vidApplVersion;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}
	public String getCookieId() {
		return cookieId;
	}
	public void setSemAppVersion(String semAppVersion) {
		this.semAppVersion = semAppVersion;
	}
	public String getSemAppVersion() {
		return semAppVersion;
	}
	public void setSpecialStudent(String specialStudent) {
		this.specialStudent = specialStudent;
	}
	public String getSpecialStudent() {
		return specialStudent;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpDate(Date ipDate) {
		this.ipDate = ipDate;
	}
	public Date getIpDate() {
		return ipDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
	
	
}
