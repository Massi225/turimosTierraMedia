package model;

import java.util.HashMap;
import java.util.Map;

public class Attraction {

	private Integer id;
	private String name;
	private Double cost;
	private Double duration;
	private Integer capacity;
	private String description;
	private String image;
	
	private Map<String, String> errors;
	

    public Attraction(String name, Double cost, Double duration, Integer capacity, String description,
            String image) {
        super();
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.duration = duration;
        this.capacity = capacity;
        this.description = description;
        this.image = image;
    }
	
	public Attraction(String name, Double cost, Double duration, Integer capacity) {
		super();
		this.name = name;
		this.cost = cost;
		this.duration = duration;
		this.capacity = capacity;
		
	}
	
	public Attraction(Integer id, String name, Double cost, Double duration, Integer capacity, String description,
            String image) {
		this(name, cost, duration, capacity);
		this.id = id;
		this.description = description;
        this.image = image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (cost <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (duration <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (duration > 60) {
			errors.put("duration", "Excede el tiempo máximo");
		}
		if (capacity <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Attraction [id=" + id + ", name=" + name + ", cost=" + cost + ", duration=" + duration + ", capacity="
				+ capacity + "]";
	}

	public boolean canHost(int i) {
		return capacity >= i;
	}

	public void host(int i) {
		this.capacity -= i;
	}

	
	
}
