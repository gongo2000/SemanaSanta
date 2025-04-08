package org.example.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "SemanaSanta")
@XmlAccessorType(XmlAccessType.FIELD)
public class SemanaSanta {
    @XmlElement(name = "cofradia")
    private List<Cofradia> semanaSanta;

    public SemanaSanta() {}

    public SemanaSanta(List<Cofradia> semanaSanta) {
        this.semanaSanta = semanaSanta;
    }

    public List<Cofradia> getSemanaSanta() {
        return semanaSanta;
    }

    public void setSemanaSanta(List<Cofradia> semanaSanta) {
        this.semanaSanta = semanaSanta;
    }
}