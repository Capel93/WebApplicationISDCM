/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Date;
import Model.SearchService;
import Model.SearchVideoWithAuthorResponse;
import Model.SearchVideoWithYearCreationDateResponse;
import Model.SearchWithVideoNameResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author JoanMarc
 */
@Path("searchserviceport")
public class SearchServicePort {

    private SearchService port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchServicePort
     */
    public SearchServicePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method searchVideoWithYearCreationDate
     * @param date resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Model.SearchVideoWithYearCreationDateResponse>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("searchvideowithyearcreationdate/")
    public JAXBElement<SearchVideoWithYearCreationDateResponse> postSearchVideoWithYearCreationDate(JAXBElement<Date> date) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<Model.Video> result = port.searchVideoWithYearCreationDate(date.getValue());

                class SearchVideoWithYearCreationDateResponse_1 extends Model.SearchVideoWithYearCreationDateResponse {

                    SearchVideoWithYearCreationDateResponse_1(java.util.List<Model.Video> _return) {
                        this._return = _return;
                    }
                }
                Model.SearchVideoWithYearCreationDateResponse response = new SearchVideoWithYearCreationDateResponse_1(result);
                return new Model.ObjectFactory().createSearchVideoWithYearCreationDateResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method hello
     * @param name resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("hello/")
    public String getHello(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.hello(name);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method searchVideoWithAuthor
     * @param author resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Model.SearchVideoWithAuthorResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("searchvideowithauthor/")
    public JAXBElement<SearchVideoWithAuthorResponse> getSearchVideoWithAuthor(@QueryParam("author") String author) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<Model.Video> result = port.searchVideoWithAuthor(author);

                class SearchVideoWithAuthorResponse_1 extends Model.SearchVideoWithAuthorResponse {

                    SearchVideoWithAuthorResponse_1(java.util.List<Model.Video> _return) {
                        this._return = _return;
                    }
                }
                Model.SearchVideoWithAuthorResponse response = new SearchVideoWithAuthorResponse_1(result);
                return new Model.ObjectFactory().createSearchVideoWithAuthorResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method searchWithVideoName
     * @param name resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Model.SearchWithVideoNameResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("searchwithvideoname/")
    public JAXBElement<SearchWithVideoNameResponse> getSearchWithVideoName(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<Model.Video> result = port.searchWithVideoName(name);

                class SearchWithVideoNameResponse_1 extends Model.SearchWithVideoNameResponse {

                    SearchWithVideoNameResponse_1(java.util.List<Model.Video> _return) {
                        this._return = _return;
                    }
                }
                Model.SearchWithVideoNameResponse response = new SearchWithVideoNameResponse_1(result);
                return new Model.ObjectFactory().createSearchWithVideoNameResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private SearchService getPort() {
        try {
            // Call Web Service Operation
            Model.SearchService_Service service = new Model.SearchService_Service();
            Model.SearchService p = service.getSearchServicePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
