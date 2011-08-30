package
{
	import mx.rpc.IResponder;

	public class LoginResponder implements IResponder
	{
		public function LoginResponder()
		{
		}
		
		public function fault(value:Object) : void {
			trace("fault: " + value)
		}

		public function result(value:Object) : void {
			trace("result: " + value)
		}
	}
}