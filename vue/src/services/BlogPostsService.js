import axios from "axios";

export default {

    getBlogPosts() {
        return axios.get('/blogposts');
    }

}