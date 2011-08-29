package  {
  [Bindable]
  [RemoteClass(alias='edu.arizona.cs.to.News')]
  public class News {
    public function News() {
      // constructor
    }

    public var id:int;
    public var dateCreated:Date;
    public var text:String;
  }
}
