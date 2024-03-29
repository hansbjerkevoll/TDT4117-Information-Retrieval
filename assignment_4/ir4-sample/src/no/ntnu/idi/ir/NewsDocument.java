package no.ntnu.idi.ir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NewsDocument {

	private String from;
	private String subject;
	private String content;
	private String id;

	public NewsDocument(File file) {
		FileReader fr;
		StringBuffer content = new StringBuffer();
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;

			while ((line = br.readLine()) != null) {

				boolean contentLine = true;
				if (line.startsWith("From:")) {
					this.from = line.substring(line.indexOf("From:") + 6);
					contentLine = false;
				}
				if (line.startsWith("Subject:")) {
					this.subject = line.substring(line.indexOf("Subject:") + 9);
					contentLine = false;
				}
				if (contentLine) {
					content.append(line);
				}
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		this.path = file.getPath();
		this.id = file.getName().toString();
		this.content = content.toString();
	}

//	@Override
//	public String toString() {
//		return file + ": " + from + " / " + subject + ": " + content;
//	}
	

	public String getId() {
		return id;
	}	

	public String getContent() {
		return content;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}
}
