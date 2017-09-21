package GUIng;

import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;
import javax.swing.*;

import GUIng_Content.Quiz_Content;
import GUIng_Content.Test_Content;

public class Timer_Set implements Runnable {
	private int tlimit = 0; // the time limit variable. you can set the value
							// using setter.
	private int min;	// minute of the timer
	private int sec;	// second of the timer
	private int time_gap;		// time limit of this class subtract from time gap between the current time and start time is the left time.  

	private JPanel tt = new JPanel(); // it is comprised of minlabel, sclabel,
										// seclabel
	private JLabel minLabel; // showing the minute.
	private JLabel scLabel; // showing the semicolon.
	private JLabel secLabel; // showing the second.

	private boolean key;	// this boolean variable decide to exit the while loop.

	private Quiz_Content quizContent;	// declare the Quiz_Content to control the time in the quiz.
	private Test_Content testcontent;	// declare the Test_Content to control the time in the test. 
										//prof.dr.teemu advised us to handle these time event 

	//add each label into panel. after that set the font and size of every label.  
	public void tt_init() {
		tt.setBounds(100, 31, 170, 80);
		tt.setBackground(new Color(204, 204, 204));
		tt.setLayout(new FlowLayout());

		tt.add(minLabel = new JLabel());
		this.minLabel.setFont(new Font("Gothic", Font.ITALIC, 60));

		tt.add(scLabel = new JLabel());
		this.scLabel.setFont(new Font("Gothic", Font.ITALIC, 60));
		this.scLabel.setText(":");

		tt.add(secLabel = new JLabel());
		this.secLabel.setFont(new Font("Gothic", Font.ITALIC, 60));

		this.tt.setVisible(false);
	}

	public Quiz_Content getQuizContent() {
		return quizContent;
	}

	public void setQuizContent(Quiz_Content quizContent) {
		this.quizContent = quizContent;
	}

	public Test_Content getTestcontent() {
		return testcontent;
	}

	public void setTestcontent(Test_Content testcontent) {
		this.testcontent = testcontent;
	}

	@Override
	public void run() {
		final Date start_time = new Date();

		key = true;
		while (key) {
			try {
				final Date currnet_time = new Date();

				time_gap = (int) ((int) tlimit - ((currnet_time.getTime() - start_time.getTime()) / 1000));

				min = time_gap / 60;
				sec = time_gap - (min * 60);

				this.minLabel.setText("" + min);
				this.secLabel.setText("" + sec);

				if (time_gap == 0) { // if time is over, set the boolean key
										// to false to exit the while loop.
					key = false;
					JOptionPane.showMessageDialog(null, "Time is Over!!");
					if (getTestcontent() != null) {
						if (testcontent.getSubmit().isVisible()) {	//checks when to submit the test by considering that submit btn is visible. 
							testcontent.doSubmit();
							testcontent.getSubmit().setVisible(false);
							testcontent.remove(testcontent.getSubmit());
						}

					}
					if (getQuizContent() != null) {
						if (quizContent.getSubmit_btn().isVisible()) {	//checks when to submit the quiz by considering that submit btn is visible. 
							quizContent.doSubmit();
							quizContent.getSubmit_btn().setVisible(false);
							quizContent.remove(quizContent.getSubmit_btn());
						}
					}
					tt.setVisible(false);
				}
				if (getQuizContent() != null) {	// when submit btn is clicked while timer is not over, ceasing the timer.  
					if (!quizContent.getSubmit_btn().isVisible()) {
						getTt().setVisible(false);
						setKey(false);
						setTlimit(0);
					}
				}
				if (getTestcontent() != null) {
					if (!testcontent.getSubmit().isVisible()) {
						getTt().setVisible(false);
						setKey(false);
						setTlimit(0);
					}
				}
				Thread.sleep(1000); //TA jeongryeol advised us to using thread to implement timer into this app.

			} catch(Exception e){
				JOptionPane.showMessageDialog(null, "Exception occured!");
			}

			
		}

	}

	public void check() {
		// TODO Auto-generated method stub

	}

	public int getTlimit() {
		return tlimit;
	}

	public void setTlimit(int tlimit) {
		this.tlimit = tlimit;
	}

	public JPanel getTt() {
		return tt;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

	public boolean isKey() {
		return key;
	}

	public void clear() {
		this.min = 0;
		this.sec = 0;
		this.time_gap = 0;
	}
}
/* make getter and setter*/