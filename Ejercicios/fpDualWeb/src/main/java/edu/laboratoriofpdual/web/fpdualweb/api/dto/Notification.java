package edu.laboratoriofpdual.web.fpdualweb.api.dto;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "notification")
public class Notification {

	private int id;
	private String title;
	private String body;
	
}
