package com.office.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏类
 * 
 * @author Administrator
 * 
 */
public class GameDTO {
	private int numberA;
	private int numberB;
	private int numberC;
	private int numberD;

	private int numA;
	private int numB;
	private int numC;
	private int numD;

	private List<String> answerList;
	private int answerCount;// 解法总数
	private String solution;// 输入的答案

	private long startDate;
	private long endDate;

	public int getNumberA() {
		return numberA;
	}

	public void setNumberA(int numberA) {
		this.numberA = numberA;
	}

	public int getNumberB() {
		return numberB;
	}

	public void setNumberB(int numberB) {
		this.numberB = numberB;
	}

	public int getNumberC() {
		return numberC;
	}

	public void setNumberC(int numberC) {
		this.numberC = numberC;
	}

	public int getNumberD() {
		return numberD;
	}

	public void setNumberD(int numberD) {
		this.numberD = numberD;
	}

	public int getNumA() {
		return numA;
	}

	public void setNumA(int numA) {
		this.numA = numA;
	}

	public int getNumB() {
		return numB;
	}

	public void setNumB(int numB) {
		this.numB = numB;
	}

	public int getNumC() {
		return numC;
	}

	public void setNumC(int numC) {
		this.numC = numC;
	}

	public int getNumD() {
		return numD;
	}

	public void setNumD(int numD) {
		this.numD = numD;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public List<String> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<String> answerList) {
		this.answerList = answerList;
	}
	
	public List<Integer> getNumberList(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(this.numberA);
		list.add(this.numberB);
		list.add(this.numberC);
		list.add(this.numberD);
		return list;
	}
	
	public int[] getNumberArray(){
		int[] array={this.numberA,this.numberB,this.numberC,this.numberD};
		return array;
	}
	
	public void setNumber(int array[]) {
		this.numberA = array[0];
		this.numberB = array[1];
		this.numberC = array[2];
		this.numberD = array[3];
	}
	
	public void setNum(int array[]){
		this.numA = array[0];
		this.numB = array[1];
		this.numC = array[2];
		this.numD = array[3];
	}

}
