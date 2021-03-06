package org.geogebra.common.media;

import org.geogebra.common.euclidian.EuclidianView;
import org.geogebra.common.kernel.geos.GeoAudio;
import org.geogebra.common.kernel.geos.GeoVideo;
import org.geogebra.common.main.App;

public class MediaFactory {

	private App app;

	public MediaFactory(App app) {
		this.app = app;
	}

	/**
	 * Add audio to construction
	 * 
	 * @param url
	 *            audio URL
	 */
	public void addAudio(String url) {
		EuclidianView ev = app.getActiveEuclidianView();
		GeoAudio audio = new GeoAudio(app.getKernel().getConstruction(), url);
		audio.setAbsoluteScreenLoc((ev.getWidth() - audio.getWidth()) / 2,
				(ev.getHeight() - audio.getHeight()) / 2);
		audio.setLabel(null);
		app.storeUndoInfo();
		app.getActiveEuclidianView().repaint();
	}

	/**
	 * Create video and add it to construction.
	 * 
	 * @param videoUrl
	 *            video URL
	 */
	public void addVideo(VideoURL videoUrl) {
		EuclidianView ev = app.getActiveEuclidianView();
		GeoVideo video = app.getVideoManager().createVideo(app.getKernel().getConstruction(),
				videoUrl);
		video.setBackground(true);
		video.setAbsoluteScreenLoc((ev.getWidth() - video.getWidth()) / 2,
				(ev.getHeight() - video.getHeight()) / 2);
		video.setLabel(null);
		app.storeUndoInfo();
	}
}
