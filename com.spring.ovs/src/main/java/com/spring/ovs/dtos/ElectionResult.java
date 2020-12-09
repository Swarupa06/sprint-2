package com.spring.ovs.dtos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="results")
public class ElectionResult {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@DateTimeFormat(pattern="dd-mm-yyyy")
	@Column(name = "polling_date")
	private Date pollingDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidateId")
	private NominatedCandidates candidate;
    
	@NotEmpty(message = "Society name is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "coop_societyName")
	private String coop_SocietyName;
	
	@NotNull(message = "Please enter total society votes")
	@Column(name = "totalSocietyVotes")
	private int totalSocietyVotes;
	
	@NotNull(message = "Please enter total polled votes")
	@Column(name = "totalPolledVotes")
	private int totalPolledVotes;
	
	@NotNull(message = "Please enter total polling percentage")
	@Column(name = "totalPollingPercentage")
	private float totalPollingPercentage;
	
	@NotNull(message = "Please enter total candidate votes")
	@Column(name = "totalCandidateVotes")
	private int totalCandidateVotes;
	
	@NotNull(message = "Please enter candidate votes percentage")
	@Column(name = "candidateVotesPercentage")
	private float candidateVotesPercentage;
	
	@NotEmpty(message = "Result is required")
	@Column(name = "result")
	private String result;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Date getPollingDate()
	{
		return pollingDate;
	}
	public void setPollingDate(Date pollingDate)
	{
		this.pollingDate = pollingDate;
	}
	
	
	public NominatedCandidates getCandidate() 
	{
		return candidate;
	}
	public void setCandidate(NominatedCandidates candidate) 
	{
		this.candidate = candidate;
	}
	public String getCoop_SocietyName()
	{
		return coop_SocietyName;
	}
	public void setCoop_SocietyName(String coop_SocietyName)
	{
		this.coop_SocietyName = coop_SocietyName;
	}
	public int getTotalSocietyVotes() 
	{
		return totalSocietyVotes;
	}
	public void setTotalSocietyVotes(int totalSocietyVotes)
	{
		this.totalSocietyVotes = totalSocietyVotes;
	}
	public int getTotalPolledVotes()
	{
		return totalPolledVotes;
	}
	public void setTotalPolledVotes(int totalPolledVotes)
	{
		this.totalPolledVotes = totalPolledVotes;
	}
	public float getTotalPollingPercentage()
	{
		return totalPollingPercentage;
	}
	public void setTotalPollingPercentage(float totalPollingPercentage)
	{
		this.totalPollingPercentage = totalPollingPercentage;
	}
	public int getTotalCandidateVotes()
	{
		return totalCandidateVotes;
	}
	public void setTotalCandidateVotes(int totalCandidateVotes)
	{
		this.totalCandidateVotes = totalCandidateVotes;
	}
	public float getCandidateVotesPercentage()
	{
		return candidateVotesPercentage;
	}
	public void setCandidateVotesPercentage(float candidateVotesPercentage)
	{
		this.candidateVotesPercentage = candidateVotesPercentage;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	

	public ElectionResult()
	{
		
	}
	public ElectionResult(Date pollingDate, NominatedCandidates candidate, String coop_SocietyName,
			int totalSocietyVotes, int totalPolledVotes, float totalPollingPercentage, int totalCandidateVotes,
			float candidateVotesPercentage, String result) 
	{
		super();
		this.pollingDate = pollingDate;
		this.candidate = candidate;
		this.coop_SocietyName = coop_SocietyName;
		this.totalSocietyVotes = totalSocietyVotes;
		this.totalPolledVotes = totalPolledVotes;
		this.totalPollingPercentage = totalPollingPercentage;
		this.totalCandidateVotes = totalCandidateVotes;
		this.candidateVotesPercentage = candidateVotesPercentage;
		this.result = result;
	}
	
	public ElectionResult(int id, Date pollingDate, NominatedCandidates candidate, String coop_SocietyName,
			int totalSocietyVotes, int totalPolledVotes, float totalPollingPercentage, int totalCandidateVotes,
			float candidateVotesPercentage, String result)
	{
		super();
		this.id = id;
		this.pollingDate = pollingDate;
		this.candidate = candidate;
		this.coop_SocietyName = coop_SocietyName;
		this.totalSocietyVotes = totalSocietyVotes;
		this.totalPolledVotes = totalPolledVotes;
		this.totalPollingPercentage = totalPollingPercentage;
		this.totalCandidateVotes = totalCandidateVotes;
		this.candidateVotesPercentage = candidateVotesPercentage;
		this.result = result;
	}
	
	@Override
	public String toString()
	{
		return "ElectionResult [id=" + id + ", pollingDate=" + pollingDate + ", candidate=" + candidate
				+ ", coop_SocietyName=" + coop_SocietyName + ", totalSocietyVotes=" + totalSocietyVotes
				+ ", totalPolledVotes=" + totalPolledVotes + ", totalPollingPercentage=" + totalPollingPercentage
				+ ", totalCandidateVotes=" + totalCandidateVotes + ", candidateVotesPercentage="
				+ candidateVotesPercentage + ", result=" + result + "]";
	}
	
}

