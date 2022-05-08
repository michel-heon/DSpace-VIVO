package org.vivoweb.dspacevivo.transformation.harvester.oai;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.vivoweb.dspacevivo.model.Collection;
import org.vivoweb.dspacevivo.model.Community;
import org.vivoweb.dspacevivo.model.Item;
import org.vivoweb.dspacevivo.model.Repository;
import org.vivoweb.dspacevivo.transformation.harvester.DspaceHarvester;

public class DspaceOAI extends DspaceHarvester {

    private static final String NO_TOKEN = null;
    private String resumptionToken = NO_TOKEN;
    private URI baseURI;
    private String verb;
    private String metadata;
    private String until;
    private String from;
    private String set;
    private String identifier;
    private OAIPMHHttpClient httpClient;
    private boolean empty = false;
    private List<String> recoverSets;

    public DspaceOAI(Properties prprts) {
        super(prprts);
    }

    @Override
    public void connect() {
        try {
            this.baseURI = new URI(this.conf.getProperty("endpoint"));
        } catch (URISyntaxException ex) {
        }
        this.httpClient = new OAIPMHHttpClient();
    }

    @Override
    public Iterator<Item> harvestItems() {
        this.verb = "ListRecords";
        this.metadata = "xoai";
        this.until = null;
        this.from = null;
        this.set = null;
        this.identifier = null;
        this.recoverSets = null;

        if (OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListMetadataFormats || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListSets
                || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.Identify) {
            this.metadata = null;
            this.until = null;
            this.from = null;
            this.set = null;
            this.identifier = null;
        }
        return new ItemItr(this);
    }

    public List<String> getRecoverSets() {
        return recoverSets;
    }

    public void setRecoverSets(List<String> recoverSets) {
        this.recoverSets = recoverSets;
    }

    @Override
    public Iterator<Collection> harvestCollection() {
        this.verb = "ListSets";
        this.metadata = null;
        this.until = null;
        this.from = null;
        this.set = null;
        this.identifier = null;

        if (OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListMetadataFormats || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListSets
                || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.Identify) {
            this.metadata = null;
            this.until = null;
            this.from = null;
            this.set = null;
            this.identifier = null;
        }
        return new CollectionItr(this);
    }

    @Override
    public Iterator<Community> harvestCommunity() {
        this.verb = "ListSets";
        this.metadata = null;
        this.until = null;
        this.from = null;
        this.set = null;
        this.identifier = null;

        if (OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListMetadataFormats || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListSets
                || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.Identify) {
            this.metadata = null;
            this.until = null;
            this.from = null;
            this.set = null;
            this.identifier = null;
        }
        return new CommunityItr(this);
    }

    @Override
    public Iterator<Repository> harvestRepository() {
        this.verb = "Identify";
        this.metadata = null;
        this.until = null;
        this.from = null;
        this.set = null;
        this.identifier = null;

        if (OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListMetadataFormats || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.ListSets
                || OAIPMHVerb.valueOf(verb) == OAIPMHVerb.Identify) {
            this.metadata = null;
            this.until = null;
            this.from = null;
            this.set = null;
            this.identifier = null;
        }
        return new RepositoryItr(this);
    }

    public String getResumptionToken() {
        return resumptionToken;
    }

    public void setResumptionToken(String resumptionToken) {
        this.resumptionToken = resumptionToken;
    }

    public URI getBaseURI() {
        return baseURI;
    }

    public void setBaseURI(URI baseURI) {
        this.baseURI = baseURI;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public OAIPMHHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(OAIPMHHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

}
