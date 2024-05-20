package com.hahapotoman.dev.book.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookLogId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	
	@Column(columnDefinition = "TEXT")
	private String comment;
	
	private Integer page;
	
	@CreationTimestamp
	private LocalDateTime insertDateTime;
	
}
