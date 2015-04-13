package de.fst.scheckcheck.endpoint.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import de.fst.scheckcheck.domain.entity.Member;
import de.fst.scheckcheck.domain.resource.MemberRO;

/**
 * REST Endpoint for {@link Member}.
 */
@Stateless
@Path("/members")
public class MemberEndpoint {

  @PersistenceContext(unitName = "scheckcheck-PU")
  private EntityManager em;

  @POST
  @Consumes("application/json")
  public Response create(MemberRO dto) {
    Member entity = dto.fromDTO(null, em);
    em.persist(entity);
    return Response.created(
        UriBuilder.fromResource(MemberEndpoint.class).path(String.valueOf(entity.getId())).build())
        .build();
  }

  @DELETE
  @Path("/{id:[0-9][0-9]*}")
  public Response deleteById(@PathParam("id") Long id) {
    Member entity = em.find(Member.class, id);
    if (entity == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    em.remove(entity);
    return Response.noContent().build();
  }

  @GET
  @Path("/{id:[0-9][0-9]*}")
  @Produces("application/json")
  public Response findById(@PathParam("id") Long id) {
    TypedQuery<Member> findByIdQuery = em.createQuery(
        "SELECT DISTINCT m FROM Member m WHERE m.id = :entityId ORDER BY m.id", Member.class);
    findByIdQuery.setParameter("entityId", id);
    Member entity;
    try {
      entity = findByIdQuery.getSingleResult();
    } catch (NoResultException nre) {
      entity = null;
    }
    if (entity == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    MemberRO dto = new MemberRO(entity);
    return Response.ok(dto).build();
  }

  @GET
  @Produces("application/json")
  public Response listAll() {
    final List<Member> searchResults = em.createQuery(
        "SELECT DISTINCT m FROM Member m ORDER BY m.id", Member.class).getResultList();
    final List<MemberRO> results = new ArrayList<MemberRO>();
    for (Member searchResult : searchResults) {
      MemberRO dto = new MemberRO(searchResult);
      results.add(dto);
    }
    // return results;
    return Response.ok(results).build();
  }

  @PUT
  @Path("/{id:[0-9][0-9]*}")
  @Consumes("application/json")
  public Response update(@PathParam("id") Long id, MemberRO dto) {
    TypedQuery<Member> findByIdQuery = em.createQuery(
        "SELECT DISTINCT m FROM Member m WHERE m.id = :entityId ORDER BY m.id", Member.class);
    findByIdQuery.setParameter("entityId", id);
    Member entity;
    try {
      entity = findByIdQuery.getSingleResult();
    } catch (NoResultException nre) {
      entity = null;
    }
    entity = dto.fromDTO(entity, em);
    entity = em.merge(entity);
    return Response.noContent().build();
  }
}