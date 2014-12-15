package ol.examples;

import ol.FeatureOverlay;
import ol.Map;
import ol.layer.Tile;
import ol.source.MapQuest;
import ol.style.Circle;
import ol.style.Fill;
import ol.style.Stroke;
import ol.style.Style;
import olx.MapOptions;
import olx.layer.TileOptions;
import olx.source.MapQuestOptions;
import olx.style.CircleOptions;
import olx.style.FillOptions;
import olx.style.StrokeOptions;
import olx.style.StyleOptions;

public class DrawAndModifyFeatures {

  public void x() {
    final MapQuestOptions mapQuestOptions = new MapQuestOptions();
    mapQuestOptions.setLayer("sat");
    final TileOptions tileOptions = new TileOptions();
    tileOptions.setSource(MapQuest.newMapQuest(mapQuestOptions));
    final Tile raster = Tile.newTile(tileOptions);

    final MapOptions mapOptions = new MapOptions();
    final Map map = Map.newMap(mapOptions);
    //    final MapWidget mapWidget = new MapWidget(mapOptions);
    //    mapWidget.getMap();
    map.addLayer(raster);

    //  var map = new ol.Map({
    //    layers: [raster],
    //    target: 'map',
    //    view: new ol.View({
    //      center: [-11000000, 4600000],
    //      zoom: 4
    //    })
    //  });

    // The features are not added to a regular vector layer/source,
    // but to a feature overlay which holds a collection of features.
    // This collection is passed to the modify and also the draw
    final StyleOptions styleOptions = new StyleOptions();

    final FillOptions fillOptions = new FillOptions();
    fillOptions.setColor("rgba(255, 255, 255, 0.2)");
    styleOptions.setFill(Fill.newFill(fillOptions));

    final StrokeOptions strokeOptions = new StrokeOptions();
    strokeOptions.setColor("#ffcc33");
    strokeOptions.setWidth(2);
    styleOptions.setStroke(Stroke.newStroke(strokeOptions));

    final CircleOptions cicleOptions = new CircleOptions();
    cicleOptions.setRadius(7);
    final FillOptions circleFillOptions = new FillOptions();
    circleFillOptions.setColor("#ffcc33");
    cicleOptions.setFill(Fill.newFill(circleFillOptions));
    styleOptions.setImage(Circle.newCircle(cicleOptions));

    final FeatureOverlay featureOverlay = FeatureOverlay.newFeatureOverlay();
    featureOverlay.setStyle(Style.newStyle(styleOptions));
    featureOverlay.setMap(map);


  }
  //
  //  var modify = new ol.interaction.Modify({
  //    features: featureOverlay.getFeatures(),
  //    // the SHIFT key must be pressed to delete vertices, so
  //    // that new vertices can be drawn at the same position
  //    // of existing vertices
  //    deleteCondition: function(event) {
  //      return ol.events.condition.shiftKeyOnly(event) &&
  //          ol.events.condition.singleClick(event);
  //    }
  //  });
  //  map.addInteraction(modify);
  //
  //  var draw; // global so we can remove it later
  //  function addInteraction() {
  //    draw = new ol.interaction.Draw({
  //      features: featureOverlay.getFeatures(),
  //      type: /** @type {ol.geom.GeometryType} */ (typeSelect.value)
  //    });
  //    map.addInteraction(draw);
  //  }
  //
  //  var typeSelect = document.getElementById('type');
  //
  //
  //  /**
  //   * Let user change the geometry type.
  //   * @param {Event} e Change event.
  //   */
  //  typeSelect.onchange = function(e) {
  //    map.removeInteraction(draw);
  //    addInteraction();
  //  };
  //
  //  addInteraction();
}
