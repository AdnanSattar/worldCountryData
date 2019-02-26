package com.blongho.country_flags.utils;
/**
 * @file ContentReader
 * @author Bernard Che Longho (blongho)
 * @since 2019-02-26
 *
 * @brief
 * This class reads the contents of any file that is specified in the assets directory
 */

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ContentReader {
	private static final String TAG = "ContentReader";

	/**
	 *
	 */
	private ContentReader() {
	}

	/**
	 * Read contents from a file
	 *
	 * @param context the application context
	 * @param path    the file name. The file should should be saved inside the assets folder
	 *
	 * @return a string the content as a string
	 * 	<p>
	 * 	NB: Call this method in a separate thread if calling from the main thread
	 **/
	public static String readFromAssets(Context context, final String path) {
		BufferedReader bufferedReader = null;
		try {
			InputStream is = context.getAssets().open(path);
			bufferedReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			int read;

			StringBuilder stringBuffer = new StringBuilder();

			char[] charsRead = new char[1024];
			while ((read = bufferedReader.read(charsRead)) != -1) {
				stringBuffer.append(charsRead, 0, read);
			}
			return stringBuffer.toString();

		} catch (IOException ex) {
			Log.e(TAG, ex.getLocalizedMessage());
			return null;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
