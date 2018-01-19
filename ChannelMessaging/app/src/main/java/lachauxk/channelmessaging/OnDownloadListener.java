package lachauxk.channelmessaging;

/**
 * Created by lachauxk on 19/01/2018.
 */
public interface OnDownloadListener {

    public void OnDownloadComplete(String downloadedContent);

    public void onDownloadError(String downloadedContent);
}
