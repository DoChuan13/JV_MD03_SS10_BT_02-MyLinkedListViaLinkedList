package LinkedList;

import java.util.LinkedList;

public class MyLinkedList<E> {

    private Node head;
    private int numNodes;

    //Step 1-1: Thiết lập Inner Class =>
    /*gồm 2 thuộc tính: "data" chứa dữ liệu của nó và "next" chứa liên kết với phần tử kế tiếp
     (nếu có, hoặc là null nếu không có)*/
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
    //Step 1-2: Thiết lập Constructor
    public MyLinkedList() {
    }

    public MyLinkedList(Object data) {
        this.head = new Node(data);
        numNodes++;
    }

    //Step 2: Thiết lập add method => thêm phần tử vào vị trí thứ index trong Array
    public void add(int index, E data) {
        //Kiểm tra giá trị của index, nếu index = 0, thì thực thi thêm vào đầu mảng/
        //index khác không thì thực việc xét các điều kiện khác
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Node Size: " + numNodes);
        }
        //Gắn giá trị gốc ban đầu vào biến temp
        Node temp = head;
        //Biến được tạo ra để giữ phần dữ liệu đuôi sau phần index-1
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            //Vòng lặp for trả ra giá trị các Object nối tiếp
            /*i=0 =>        Node 1 => temp = head.next = object1 = {data1,next}
             *i=1 =>        Node 2 => temp = temp.next = head.next.next => object1.next = object2 = {data2,next}
             * ...
             *i=index-2 =>  Node n => temp = temp.next....next = head....next.next => objectIndex-2.next = objectIndex-1 = {dataNIndex-1,next}
             *i=index-1 =>    End*/
            temp = temp.next;
        }
        //Vòng lặp for dừng lại tại vị trí index -1 =>phần Object từ index về sau được gắn sao lưu vào holder
        holder = temp.next;
        //Vòng lặp for dừng lại khi kết thúc index-1 => temp = ObjectIndex-1 = {dataNIndex-1,next}
            /*Tại nút này dữ liệu data mới được tạo và chèn vào biến "next" của Object temp
            => temp.next = ObjectIndex = {dataIndex,next} với "dataIndex" = newData và "next" = null (mặc định)*/
        temp.next = new Node(data);
        //temp.next.next = "dataIndex.next" = null => được gán lại tham chiếu với phần "holder" đã sao lưu từ trước
        temp.next.next = holder;
        //Số node = độ dài của List được cập nhật thêm
        numNodes++;

    }

    //Step 3: Thiết lập addFirst Method => thêm phần tử vào đầu Array
    public void addFirst(E data) {
        //Biến temp được gán = head, tương đương với Object 1 = {data1,next}, với "next" có tham chiếu kế tiếp
        Node temp = head;
        //Biến head được tạo mới với data truyền vào và trở thành {data1,next}, với "data1" = newData và "next" = null (mặc định);
        head = new Node(data);
        //Head mới được gắn lại tham chiếu về temp, tức là temp = Object 1 = {data1, next} sẽ được biến đổi thành Object2
        head.next = temp;
        //Số node = độ dài của List được cập nhật thêm
        numNodes++;
    }

    //Step 4: Thiết lập addLast Method => thêm phần tử vào cuối Array
    public void addLast(E data) {
        if (numNodes == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;

    }

    //Step 5: Thiết lập remove Method => xóa phần tử tại vị trí index
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Node Size: " + numNodes);
        }
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1; i++) {
            //Vòng lặp for truy xuất tới các "nextLink" tham chiếu tới phần tử kế tiếp
            //hết vòng lặp => temp = Node(index-1) = Object(index-1) (tại vòng lặp cuối cùng index-2)
            temp = temp.next;
        }
        //temp "sau for" = Node(index-1) => temp.next = Node(index) = Object(index)
        //holder lưu trữ tham chiếu cho Object(index+1) = temp.next.next

        holder = temp.next.next;
        temp.next = holder;
        numNodes--;
        return (E) temp.next;
    }

    //Step 6: Thiết lập removeMethod => xóa phần tử xuất hiện đầu tiên trong danh sách
    public boolean remove(Object e) {
        Node temp = head;
        Node holder;
        if (e == null) {
            for (int i = 0; i < numNodes; i++) {
                holder = temp.next.next;
                if (temp.next == null) {
                    temp.next = holder;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        for (int i = 0; i < numNodes; i++) {
            holder = temp.next.next;
            if (e.equals(temp.next.getData())) {
                temp.next = holder;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }

        return true;
    }

    //Step 7: Thiết lập get Method => trả ra phần tử thứ index
    public E get(int index) {
        Node temp = head;
        if (index < 0 || index >= numNodes) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Node: " + numNodes);
        }
        for (int i = 0; i < index; i++) {
            //Vòng lặp for trả ra giá trị các Object nối tiếp
            /*i=0 =>    Node 1 => temp = head.next = object1 = {data1,next}
             *i=1 =>    Node 2 => temp = temp.next = head.next.next => object1.next = object2 = {data2,next}
             * ...
             *i=index-1 =>  Node n => temp = temp.next....next = head....next.next => objectIndex-1.next = objectIndex = {dataIndex,next}
             *i=index =>    End*/
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    //Step 8: Thiết lập size Method => nhận thông tin kích thước Linked List
    public int size() {
        return this.numNodes;
    }

    //Step 9: Thiết lập printList Method => phương thức in ra danh sách Array
    public void printList() {
        Node temp = head;
        while (temp != null) {
            //Điều kiện while là temp!=null, tức là tempI-1.next = null => liên kết cuối cùng không còn nữa
            /*Sau mỗi lần lặp biến temp tiếp tục dẫn sâu vào .next => truy xuất tới các phần tử kế tiếp*/
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    //Step 10: Thiết lập clone Method => tạo ra một bản sao của Linked List
    @Override
    public MyLinkedList clone() {
        MyLinkedList<E> cloneList = new MyLinkedList();
        cloneList.head = head;
        cloneList.numNodes = numNodes;
        return cloneList;
    }

    //Step 11: Thiết lập contains Method => xác định sự tồn tại của Object trong mảng
    public boolean contains(E o) {
        return indexOf(o) > 0;
    }

    //Step 12: Thiết lập indexOf Method => trả ra vị trí thứ index trong Linked List
    public int indexOf(E o) {
        // Kiểm tra dữ liệu kiểm tra, nếu là null => tìm dữ liệu là null và trả ra index,
        // nếu khác null thì tìm giá trị equals với nó và trả ra index,
        // nếu không tim thấy thì trả về -1 (index ngoài mảng)
        Node temp = head;
        if (o == null) {
            for (int i = 0; i < numNodes; i++) {
                if (temp.getData() == null) {
                    return i;
                }
                temp = temp.next;
            }
        }
        for (int i = 0; i < numNodes; i++) {
            if (o.equals(temp.getData())) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
}
