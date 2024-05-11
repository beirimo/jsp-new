package model;

public class QueryVO {
		private int page;     // 어떤 페이지 어떤 사이즈 어떤 키로 어떤 단어(워드)를 선택할 지 
		private int size;
		private String key;
		private String word;
		/**
		 * @return the page
		 */
		public int getPage() {
			return page;
		}
		/**
		 * @param page the page to set
		 */
		public void setPage(int page) {
			this.page = page;
		}
		/**
		 * @return the size
		 */
		public int getSize() {
			return size;
		}
		/**
		 * @param size the size to set
		 */
		public void setSize(int size) {
			this.size = size;
		}
		/**
		 * @return the key
		 */
		public String getKey() {
			return key;
		}
		/**
		 * @param key the key to set
		 */
		public void setKey(String key) {
			this.key = key;
		}
		/**
		 * @return the word
		 */
		public String getWord() {
			return word;
		}
		/**
		 * @param word the word to set
		 */
		public void setWord(String word) {
			this.word = word;
		}
		@Override
		public String toString() {
			return "QueryVO [page=" + page + ", size=" + size + ", key=" + key + ", word=" + word + "]";
		}
		
		
}
