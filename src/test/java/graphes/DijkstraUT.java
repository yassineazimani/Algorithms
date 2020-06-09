/*
 * Copyright 2020 Yassine AZIMANI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package graphes;

import exceptions.GraphException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;

@RunWith(JUnit4.class)
public class DijkstraUT {

    private Dijkstra dijkstra;

    @Before
    public void setUp(){
        Float[][] distances = {};
        String[] villes = {};
        this.dijkstra = new Dijkstra(distances, villes);
    }// setUp()

    @Test
    public void calculateShortPath_when_departure_is_null_should_throw_graph_exception(){
        Assertions.assertThatThrownBy(() -> this.dijkstra.calculateShortPath(null))
                    .hasMessage("Departure is missing")
                    .isInstanceOf(GraphException.class);
    }// calculateShortPath_when_departure_is_null_should_throw_graph_exception()

    @Test
    public void calculateShortPath_when_departure_is_empty_should_throw_graph_exception(){
        Assertions.assertThatThrownBy(() -> this.dijkstra.calculateShortPath(""))
                .hasMessage("Departure is missing")
                .isInstanceOf(GraphException.class);
    }// calculateShortPath_when_departure_is_empty_should_throw_graph_exception()

    @Test
    public void calculateShortPath_should_throw_graph_exception_when_weights_havent_same_width_than_nodes_size(){
        this.dijkstra = new Dijkstra(new Float[][]{{1f,2f},{2f, 1f}}, new String[]{"A"});
        Assertions.assertThatThrownBy(() -> this.dijkstra.calculateShortPath("A"))
                .hasMessage("Weights must have the same size than the nodes (summits)")
                .isInstanceOf(GraphException.class);
    }// calculateShortPath_should_throw_graph_exception_when_weights_havent_same_width_than_nodes_size()

    @Test
    public void calculateShortPath_should_throw_graph_exception_when_weights_are_null(){
        this.dijkstra = new Dijkstra(null, new String[]{"A"});
        Assertions.assertThatThrownBy(() -> this.dijkstra.calculateShortPath("A"))
                .hasMessage("Weights are missing")
                .isInstanceOf(GraphException.class);
    }// calculateShortPath_should_throw_graph_exception_when_weights_are_null()

    @Test
    public void calculateShortPath_should_throw_graph_exception_when_weights_arent_matrix(){
        this.dijkstra = new Dijkstra(new Float[][]{{1f},{3f}}, new String[]{"A"});
        Assertions.assertThatThrownBy(() -> this.dijkstra.calculateShortPath("A"))
                .hasMessage("Weights must be a square matrix")
                .isInstanceOf(GraphException.class);
    }// calculateShortPath_should_throw_graph_exception_when_weights_arent_matrix()

    @Test
    public void calculateShortPath_should_throw_graph_exception_when_summits_are_null(){
        this.dijkstra = new Dijkstra(new Float[][]{{1f},{3f}}, null);
        Assertions.assertThatThrownBy(() -> this.dijkstra.calculateShortPath("A"))
                .hasMessage("Summits are missing")
                .isInstanceOf(GraphException.class);
    }// calculateShortPath_should_throw_graph_exception_when_summits_are_null()

    @Test
    public void calculateShortPath_should_throw_graph_exception_when_summits_are_empty(){
        this.dijkstra = new Dijkstra(new Float[][]{{1f},{2f,4f},{3f}}, new String[]{});
        Assertions.assertThatThrownBy(() -> this.dijkstra.calculateShortPath("A"))
                .hasMessage("Summits are missing")
                .isInstanceOf(GraphException.class);
    }// calculateShortPath_should_throw_graph_exception_when_summits_are_empty()

    /**                  3km
     * Graphe : Avignon ======> Rognonas
     */
    @Test
    public void calculateShortPath_between_avignon_and_rognonas_from_avignon_when_graph_has_nodes_avignon_rognonas_is_avignon_rognonas() throws GraphException {
        final Float[][] distances = {{0f, 3f}, {3f, 0f}};
        final String[] villes = {"Avignon","Rognonas"};

        this.dijkstra = new Dijkstra(distances, villes);
        this.dijkstra.calculateShortPath(villes[0]);
        Map<String, String> itineraireDetails = dijkstra.getShortDistanceTo(villes[1]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Avignon -> Rognonas");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("3.0");
    }// calculateShortPath_between_avignon_and_rognonas_from_avignon_when_graph_has_nodes_avignon_rognonas_is_avignon_rognonas()

    /**
     *                    2.8km
     * Graphe : Avignon ========> Le Pontet
     *         3km ||              |
     *             V ============ |  12km
     *          Rognonas
     */
    @Test
    public void calculateShortPath_between_avignon_and_pontet_from_avignon_when_graph_has_nodes_avignon_rognonas_pontet_is_avignon_pontet() throws GraphException {
        final Float[][] distances = {{0f, 3f, 2.8f}, {3f, 0f, 12f}, {2.8f, 12f, 0f}};
        final String[] villes = {"Avignon","Rognonas", "Le Pontet"};

        this.dijkstra = new Dijkstra(distances, villes);
        this.dijkstra.calculateShortPath(villes[0]);
        Map<String, String> itineraireDetails = dijkstra.getShortDistanceTo(villes[2]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Avignon -> Le Pontet");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("2.8");
    }// calculateShortPath_between_avignon_and_pontet_from_avignon_when_graph_has_nodes_avignon_rognonas_pontet_is_avignon_pontet()

    /**
     *                    2.8km
     * Graphe : Avignon ========> Le Pontet
     *         3km ||              |
     *             V ============ |  12km
     *          Rognonas
     */
    @Test
    public void calculateShortPath_between_avignon_and_rognonas_from_avignon_when_graph_has_nodes_avignon_rognonas_pontet_is_avignon_rognonas() throws GraphException {
        final Float[][] distances = {{0f, 3f, 2.8f}, {3f, 0f, 12f}, {2.8f, 12f, 0f}};
        final String[] villes = {"Avignon","Rognonas", "Le Pontet"};

        this.dijkstra = new Dijkstra(distances, villes);
        this.dijkstra.calculateShortPath(villes[0]);
        Map<String, String> itineraireDetails = dijkstra.getShortDistanceTo(villes[1]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Avignon -> Rognonas");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("3.0");
    }// calculateShortPath_between_avignon_and_pontet_from_avignon_when_graph_has_nodes_avignon_rognonas_pontet_is_avignon_pontet()

    /**
     *                    2.8km
     * Graphe : Avignon ========> Le Pontet
     *         3km ||              |
     *             V ============ |  12km
     *          Rognonas
     */
    @Test
    public void calculateShortPath_all_cities_from_avignon_when_graph_has_nodes_avignon_rognonas_pontet_should_success() throws GraphException {
        final Float[][] distances = {{0f, 3f, 2.8f}, {3f, 0f, 12f}, {2.8f, 12f, 0f}};
        final String[] villes = {"Avignon","Rognonas", "Le Pontet"};
        this.dijkstra = new Dijkstra(distances, villes);

        this.dijkstra.calculateShortPath(villes[0]);
        Map<String, String> itineraireDetails = dijkstra.getShortDistanceTo(villes[1]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Avignon -> Rognonas");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("3.0");

        itineraireDetails = dijkstra.getShortDistanceTo(villes[2]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Avignon -> Le Pontet");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("2.8");
    }// calculateShortPath_all_cities_from_avignon_when_graph_has_nodes_avignon_rognonas_pontet_should_success()

    /**
     *                    2.8km
     * Graphe : Avignon ========> Le Pontet
     *         3km ||              |
     *             V ============ |  12km
     *          Rognonas
     */
    @Test
    public void calculateShortPath_all_cities_from_rognonas_when_graph_has_nodes_avignon_rognonas_pontet_should_success() throws GraphException {
        final Float[][] distances = {{0f, 3f, 2.8f}, {3f, 0f, 12f}, {2.8f, 12f, 0f}};
        final String[] villes = {"Avignon","Rognonas", "Le Pontet"};
        this.dijkstra = new Dijkstra(distances, villes);

        this.dijkstra.calculateShortPath(villes[1]);
        Map<String, String> itineraireDetails = dijkstra.getShortDistanceTo(villes[0]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Rognonas -> Avignon");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("3.0");

        itineraireDetails = dijkstra.getShortDistanceTo(villes[2]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Rognonas -> Avignon -> Le Pontet");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("5.8");
    }// calculateShortPath_all_cities_from_rognonas_when_graph_has_nodes_avignon_rognonas_pontet_should_success()

    /**
     * Graphe :
     *                   4.8
     *   Pujaut ====================|
     *      \            Villeneuve-lès-Avignon
     *       \ 9.2            |             |                                            3.1
     *        \          0.1 |         0.5 |                        == Le Pontet ===================|
     *         \            |       1     |              2.8       |     3 |                 Morières-lès-Avignon
     *          === Les Angles  ========= Avignon ================|    Montfavet ===================|
     *                                      | 3                       10.2 |            2.2
     *   Aramon ======== Barbentane ===== Rognonas ========= Châteaurenard |
     *             3.88              1.5             2.3
     *
     * @throws GraphException
     */
    @Test
    public void calculateShortPath_avignon_to_aramon_when_graph_has_full_nodes_from_area_avignon_should_be_avignon_rognonas_barbentane_aramon() throws GraphException {
        final Float[][] distances = {{0f, 3f, 2.8f, 1f, 0.5f, null, null, null, null, null, null},
                                     {3f, 0f, null, null, null, null, null, 1.5f, 2.3f, null, null},
                                     {2.8f, null, 0f, null, null, null, null, null, null, 3f, 3.1f},
                                     {1f, null, null, 0f, 0.1f, 9.2f, 11f, null, null, null, null},
                                     {0.5f, null, null, 0.1f, 0f, 4.8f, null, null, null, null, null},
                                     {null, null, null, 9.2f, 4.8f, 0f, null, null, null, null, null},
                                     {null, null, null, 11f, null, null, 0f, 3.88f, null, null, null},
                                     {null, 1.5f, null, null, null, null, 3.88f, 0f, null, null, null},
                                     {null, 2.3f, null, null, null, null, null, null, 0f, 10.2f, null},
                                     {null, null, 3f, null, null, null, null, null, 10.2f, 0f, 2.2f},
                                     {null, null, 3.1f, null, null, null, null, null, null, 2.2f, 0f}};
        final String[] villes = {"Avignon","Rognonas", "Le Pontet", "Les Angles", "Villeneuve-lès-Avignon", "Pujaut", "Aramon", "Barbentane", "Châteaurenard", "Montfavet", "Morières-lès-Avignon"};
        this.dijkstra = new Dijkstra(distances, villes);

        this.dijkstra.calculateShortPath(villes[0]);
        Map<String, String> itineraireDetails = dijkstra.getShortDistanceTo(villes[6]);
        Assertions.assertThat(itineraireDetails).isNotNull();
        Assertions.assertThat(itineraireDetails).isNotEmpty();
        Assertions.assertThat(itineraireDetails.get("path")).isEqualTo("Avignon -> Rognonas -> Barbentane -> Aramon");
        Assertions.assertThat(itineraireDetails.get("distance")).isEqualTo("8.38");
    }// calculateShortPath_avignon_to_aramon_when_graph_has_full_nodes_from_area_avignon_should_be_avignon_rognonas_barbentane_aramon()

}// DijkstraUT
